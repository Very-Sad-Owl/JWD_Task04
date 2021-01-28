package by.epam.training.jwd.task04.server.service.text_builder.parser;

public class ParserFactory {

    private static final ParserFactory instance = new ParserFactory();

    private TextParser textParser;
    private SentenceParser sentenceParser;

    private ParserFactory(){
    }

    public static ParserFactory getInstance() {
        return instance;
    }

    public SentenceParser getSentenceParser(){
        if(sentenceParser == null) {
            sentenceParser = new SentenceParser();
        }
        return sentenceParser;
    }

    public TextParser getTextParser(){
        if(textParser == null) {
            textParser = new TextParser();
        }
        return textParser;
    }

}
