package indentationChecker;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

class BadIndentationException extends RuntimeException {
	BadIndentationException(String error) {
		super(error);
	}
}

public class IndentationChecker {
	Stack<Integer> indentStack = new Stack<Integer>();

	private int findFirstNonBlank(String line) {
		// return index of first non-blank character
		// return -1 if the line doesn't contain a non-blank character
		if (line.strip().isEmpty())
			return -1;
		return line.length() - line.stripLeading().length();
	}

	private void processLine(String line, int lineNumber) {
		int index = findFirstNonBlank(line);
		if (index == -1) {
			return;
		}

		if (indentStack.isEmpty()) {
			indentStack.push(index);
			return;
		}

		if (index > indentStack.peek()) {
			indentStack.push(index);
			return;
		}

		while (indentStack.peek() > index) {
			indentStack.pop();
		}

		if (indentStack.peek() != index) {
			throw new BadIndentationException("Line number: " + lineNumber);
		}
		// At his point the top of the stack should match the current index. If it
// doesn't throw a BadIndentationException. In the error message, include the source Line Number
	}

	public void checkIndentation(String fileName) {
		indentStack.clear();
		Scanner input = null;
		try {
			input = new Scanner(new File(fileName));
			int lineCount = 1;
			while (input.hasNextLine()) {
				processLine(input.nextLine(), lineCount++);
			}
		}

		catch (BadIndentationException error) {
			System.out.println(error);
		} catch (FileNotFoundException e) {
			System.out.println("Can't open file:" + fileName);
		} finally {
			if (input != null)
				input.close();
		}
	}

	public static void main(String[] args) {
		IndentationChecker indentChecker = new IndentationChecker();
		for (int i = 0; i < args.length; i++) {
			System.out.println("Processing file: " + args[i]);
			System.out.println(args[i]);
			indentChecker.checkIndentation(args[i]);
		}
	}
}