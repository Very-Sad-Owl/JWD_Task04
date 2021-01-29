package by.epam.training.jwd.task04.server.network;

import by.epam.training.jwd.task04.bean.network.ClientRequest;
import by.epam.training.jwd.task04.bean.text_components.impl.composite.Text;
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
			Text content = builder.parseText(strText);

			LOGGER.info("Server received text\n");

			Text res;
			ClientRequest req = ((ClientRequest) in.readObject());
			LOGGER.info("task " + req.getTaskCode() + " selected\n");

			switch (req.getTaskCode()) {
				case 0:
					out.writeObject(content);
					out.flush();
					break;
				case 1:
					res = operation.sentencesWithSimilarWordsCount(content);
					out.writeObject(res);
					out.flush();
					break;
				case 2:
					res = operation.sentenceByWordsCount(content);
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
					res = operation.equalLengthWordsInQSentences(content, (Integer) req.getParams().get("len"));
					out.writeObject(res);
					out.flush();
					break;
				case 5:
					res = operation.swapFirstAndLastWords(content);
					out.writeObject(res);
					out.flush();
					break;
				case 6:
					res = operation.wordsByAlphOrder(content);
					out.writeObject(res);
					out.flush();
					break;
				case 7:
					res = operation.wordsByVowelsProportion(content);
					out.writeObject(res);
					out.flush();
					break;
				case 8:
					res = operation.wordsWithFirstVowelByFirsConsonantAlph(content);
					out.writeObject(res);
					out.flush();
					break;
				case 9:
					res = operation.wordsByGivenLetterPresence(content, (String) req.getParams().get("symbol"));
					out.writeObject(res);
					out.flush();
					break;
				case 10:
					res = operation.wordsByPresenceInText(content, (String) req.getParams().get("words"));
					out.writeObject(res);
					out.flush();
					break;
				case 11:
					res = operation.removeCertainSubstring(content, (String) req.getParams().get("char1"),
							(String) req.getParams().get("char2"));
					out.writeObject(res);
					out.flush();
					break;
				case 12:
					res = operation.removeWordsWithFirstConsonant(content, (Integer) req.getParams().get("len"));
					out.writeObject(res);
					out.flush();
					break;
				case 13:
					res = operation.sortWordsBySymbolPresence(content, (String) req.getParams().get("symbol"));
					out.writeObject(res);
					out.flush();
					break;
				case 14:
					res = operation.findMaxPalindromSubstring(content);
					out.writeObject(res);
					out.flush();
					break;
				case 15:
					res = operation.modifyWords(content);
					out.writeObject(res);
					out.flush();
					break;
				case 16:
					res = operation.replaceWordsWithSubstring(content, (Integer) req.getParams().get("len"),
							(String) req.getParams().get("substr"));
					out.writeObject(res);
					out.flush();
					break;
			}


			LOGGER.info("Client disconnected\n");
			LOGGER.info("Closing connections and channels...\n");

			in.close();
			out.close();

			clientDialog.close();

			LOGGER.info("Connections and channels have been closed\n");

		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
