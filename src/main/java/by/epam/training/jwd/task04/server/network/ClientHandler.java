package by.epam.training.jwd.task04.server.network;

import by.epam.training.jwd.task04.bean.impl.composite.Text;
import by.epam.training.jwd.task04.server.service.text_builder.TextBuilder;
import by.epam.training.jwd.task04.server.service.text_builder.TextBuilderFactory;
import by.epam.training.jwd.task04.server.service.operation.TextOperation;
import by.epam.training.jwd.task04.server.service.operation.impl.TextOperationImpl;
import org.apache.log4j.Logger;

import java.io.*;
import java.net.Socket;

public class ClientHandler implements Runnable {

	private static Socket clientDialog;
	private static TextOperation operation = new TextOperationImpl();
	private Text content;
	private static final Logger LOGGER = Logger.getLogger(ClientHandler.class);

	public ClientHandler(Socket client) {
		clientDialog = client;
	}

	@Override
	public void run() {

		try {
			ObjectOutputStream out = new ObjectOutputStream(clientDialog.getOutputStream());

			ObjectInputStream in = new ObjectInputStream(clientDialog.getInputStream());

			TextBuilderFactory factory = TextBuilderFactory.getInstance();
			TextBuilder builder = factory.getBuilder();
			String strText = (String)in.readObject();
			content = builder.parseText(strText);
			LOGGER.info("Server received text\n");
			boolean inUse = true;

			while (inUse) {
				Text res;
				int task = ((Integer)in.readObject());
				LOGGER.info("task " + task + " selected\n");
				switch (task){
					case 0:
						out.writeObject(content);
						out.flush();
						break;
					case 1:
						res = operation.sentencesWithSimilarWordsCount(content);
						System.out.println(res.getContent());
						out.writeObject(res);
						out.flush();
						break;
					case 2:
						res = operation.sentenceByWordsCount(content);
						System.out.println(res.getContent());
						out.writeObject(res);
						out.flush();
						break;
					case 3:
						res = operation.firstSentenceOriginalWord(content);
						System.out.println(res.getContent());
						out.writeObject(res);
						out.flush();
						break;
					case 4:
						int len = (Integer)in.readObject();
						res = operation.equalLengthWordsInQSentences(content, len);
						System.out.println(res.getContent());
						out.writeObject(res);
						out.flush();
						break;
					case 5:
						res = operation.swapFirstAndLastWords(content);
						System.out.println(res.getContent());
						out.writeObject(res);
						out.flush();
						break;
					case 6:
						res = operation.wordsByAlphOrder(content);
						System.out.println(res.getContent());
						out.writeObject(res);
						out.flush();
						break;
					case 7:
						res = operation.wordsByVowelsProportion(content);
						System.out.println(res.getContent());
						out.writeObject(res);
						out.flush();
						break;
					case 8:
						res = operation.wordsWithFirstVowelByFirsConsonantAlph(content);
						System.out.println(res.getContent());
						out.writeObject(res);
						out.flush();
						break;
					case 9:
						String letter = (String)in.readObject();
						res = operation.wordsByGivenLetterPresence(content, letter);
						System.out.println(res.getContent());
						out.writeObject(res);
						out.flush();
						break;
					case 10:
						String words = (String)in.readObject();
						res = operation.wordsByPresenceInText(content, words);
						System.out.println(res.getContent());
						out.writeObject(res);
						out.flush();
						break;
					case 11:
						String substring = (String)in.readObject();
						res = operation.removeCertainSubstring(content, substring);
						System.out.println(res.getContent());
						out.writeObject(res);
						out.flush();
						break;
					case 12:
						int len12 = (Integer)in.readObject();
						res = operation.removeWordsWithFirstConsonant(content, len12);
						System.out.println(res.getContent());
						out.writeObject(res);
						out.flush();
						break;
					case 13:
						String symbol13 = (String)in.readObject();
						res = operation.sortWordsBySymbolPresence(content, symbol13);
						System.out.println(res.getContent());
						out.writeObject(res);
						out.flush();
						break;
					case 14:
						res = operation.findMaxPalindromSubstring(content);
						System.out.println(res.getContent());
						out.writeObject(res);
						out.flush();
						break;
					case 15:
						res = operation.modifyWords(content);
						System.out.println(res.getContent());
						out.writeObject(res);
						out.flush();
						break;
					case 16:
						int len16 = (Integer)in.readObject();
						String substring16 = (String)in.readObject();
						res = operation.replaceWordsWithSubstring(content, len16, substring16);
						System.out.println(res.getContent());
						out.writeObject(res);
						out.flush();
						break;
					default:
						inUse = false;
						break;
				}
			}

			LOGGER.info("Client disconnected\n");
			LOGGER.info("Closing connections & channels.\n");

			in.close();
			out.close();

			clientDialog.close();

			LOGGER.info("Closing connections & channels - DONE.\n");

		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
