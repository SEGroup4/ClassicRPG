import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

/**
 * A class to manage a question bank and a random access file, including adding
 * new questions, deleting questions and displaying all of the questions,
 * answers and point values through a random access file medium. A container
 * class.
 * 
 * @author Randy Quimby
 * @version 1.0
 * 
 *          COP3022 Project#: 4 File Name: Administration.java
 */
public class Administration {
	/**
	 * Constant for the number of bytes for a question in a file
	 */
	public static final int QUESTION_SIZE = 52;
	/**
	 * Constant for the number of bytes for an answer in a file
	 */
	public static final int ANSWER_SIZE = 22;
	/**
	 * Constant for the number of bytes for points in a file
	 */
	public static final int POINT_SIZE = 4;
	/**
	 * Constant for the number of bytes for a question ID in a file
	 */
	public static final int QUERY_ID_SIZE = 4;
	/**
	 * Constant for the total size of each record in a file
	 */
	public static final int RECORD_SIZE = QUESTION_SIZE + ANSWER_SIZE + POINT_SIZE + QUERY_ID_SIZE;
	/**
	 * The random access file to store question data
	 */
	private RandomAccessFile file;

	/**
	 * Constructs an Administration object that is not associated with a file
	 */
	public Administration() {
		this.file = null;
	}

	/**
	 * A command line menu with choices to list, add, or delete questions or quit
	 * and begin the game. Sets up the respective methods by taking in the user
	 * input.
	 * @param input the Scanner object for input
	 */
	public void adminMenu(Scanner input) throws IOException {
		boolean quit = false;
		while (!quit) {
			System.out.println("Trivia Game Administration\n" + "1. List all questions\n" + "2. Delete question\n"
					+ "3. Add question\n" + "4. Quit (Begin Trivia)\n" + "Enter choice:");
			int menuItem = input.nextInt();

			switch (menuItem) {
			case 1:
				listQuestions();
				System.out.println("Press Enter to continue...");
				input.nextLine();
				// Used to pause game and view the list.
				@SuppressWarnings("unused")
				String junk = input.nextLine();
				break;
			case 2:
				int questionNumber = (int) (file.length() / RECORD_SIZE);
				if (questionNumber > 0) {
					System.out.println("There are " + questionNumber + " questions on record.");
					System.out.println("Questions are numbered 1, 2, 3... n.  Choose a number from 1-" + questionNumber
							+ " to delete a question: ");
					int questionID = input.nextInt();
					deleteQuestion(questionNumber, questionID);
				} else
					System.out.println("There are no questions to delete!");
				break;
			case 3:
				String query = "";
				String answer = "";
				String pointValue = "";

				try {
					System.out.println("Enter new question: ");
					input.nextLine();
					query = input.nextLine();
					
					// If statements test for exceptions
					if (query.length() > 50) {
						throw new ExcessiveBytesException();
					}
					System.out.println("Enter the answer: ");
					answer = input.nextLine();
					if (answer.length() > 20) {
						throw new ExcessiveBytesException();
					}
					System.out.println("Enter the point value (1-5): ");
					pointValue = input.next();
					if (!pointValue.matches("[1-5]{1}")) {
						throw new PointValueException();
					}
					int points = Integer.valueOf(pointValue);
					
					// Stores input data in a question object
					Questions question = new Questions(query, answer, points);
					addQuestion(question);
				} catch (ExcessiveBytesException e) {
					System.out.println(e.getMessage());
				} catch (PointValueException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 4:
				System.out.println("");
				quit = true;
				break;
			default:
				System.out.println("Invalid Choice.");
			}
		}
	}

	/**
	 * Opens the data file
	 * @param filename the name of the file containing question data
	 */
	public void open(String filename) throws IOException {
		if (file != null)
			file.close();
		file = new RandomAccessFile(filename, "rw");
	}

	/**
	 * Allows entry of new questions, answers and question point value into the file
	 * and establishes the correct format for each to accommodate a record size
	 * @param question the question object containing questions, answers and point value
	 */
	private void addQuestion(Questions question) throws IOException {
		
		// reestablishes the question ID to the correct ID number relative to the number of questions entered
		int recordNum = (int) ((file.length() / RECORD_SIZE) + 1);
		question.setQuestionId(recordNum);
		file.seek(file.length());
		String questionID = String.format("%2s", question.getQuestionId());
		file.writeUTF(questionID);
		String questions = String.format("%50s", question.getQuestion());
		file.writeUTF(questions);
		String answer = String.format("%20s", question.getAnswer());
		file.writeUTF(answer);
		String pointValue = String.format("%2s", question.getPointValue());
		file.writeUTF(pointValue);
		Questions.setNextIDNum(1);
	}

	/**
	 * Closes the data file
	 */
	public void close() throws IOException {
		if (file != null)
			file.close();
		file = null;
	}

	/**
	 * Deletes a question using user input by resorting the data in the file. Writes
	 * everything but the chosen question back to the file.
	 * @param questionNumber the number of records/questions on file
	 * @param questionId the ID of a question to delete
	 */
	public void deleteQuestion(int questionNumber, int questionId) throws IOException {
		long question = findBytes(questionId);
		
		// Makes use of a byte array to read/write (then truncate) an entire file
		// without the deleted question
		byte[] notDeleted = new byte[(int) (file.length() - question - RECORD_SIZE)];
		file.seek(0);
		try {
			for (int i = 0; i < questionNumber; i++) {
				long bytes = i * RECORD_SIZE;
				if (bytes == question) {
					file.seek(questionId * RECORD_SIZE);
					file.read(notDeleted);
					file.seek(question);
					file.write(notDeleted);
				}
			}
			file.setLength(file.length() - RECORD_SIZE);
		} catch (EOFException e) {
			System.out.println("End of file.");
		}
	}

	/**
	 * Finds the location of a user input selection of a question with a given
	 * number and returns the number of bytes that location is in the file
	 * @param questionId the number to find
	 * @return the position of the account with the given number
	 */
	private long findBytes(int questionId) throws IOException {
		long inputNumber = (questionId - 1) * RECORD_SIZE;
		return inputNumber;
	}

	/**
	 * Displays all of the questions, answers and associated point values
	 */
	public void listQuestions() throws IOException {
		file.seek(0);
		try {
			while (true) {
				String iD = file.readUTF();
				String question = file.readUTF();
				String answer = file.readUTF();
				String point = file.readUTF();
				System.out.println(iD.trim() + " " + question.trim() + " " + answer.trim() + " " + point.trim());
			}
		} catch (EOFException e) {
			System.out.println("No more questions in file.");
		}
	}

	/**
	 * Returns the file with question data (random access file)
	 * @return the file with question data
	 */
	public RandomAccessFile getFile() {
		return file;
	}
}
