package by.epam.training.jwd.task04.server.service.text_builder.parser;

import by.epam.training.jwd.task04.bean.impl.composite.Text;
import by.epam.training.jwd.task04.bean.impl.Code;
import by.epam.training.jwd.task04.server.resource_manager.ResourceManager;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static by.epam.training.jwd.task04.server.service.text_builder.properties.TextParserProperties.*;

public class TextParser {

    private static final ResourceManager manager = ResourceManager.getInstance();
    private static Pattern pattern = Pattern.compile
            (manager.getValue(TEXT_PARTS));
//            ("(?<text>[^{}]+)|(?<code>.*\\{\\n(.*\\n)+?\\n*}\\n|.*(\\w = .+)\\n|(.*;)\\n)");

    public TextParser(){}

    public Text parse(String source){
        Text text = new Text();
        ParserFactory factory = ParserFactory.getInstance();
        SentenceParser parser = factory.getSentenceParser();
        Matcher matcher = pattern.matcher(source);

        while (matcher.find()) {
            String textBlock = matcher.group(manager.getValue(TEXT_BLOCK));
            String codeBLock = matcher.group(manager.getValue(CODE_BLOCK));

            if (textBlock != null) {
                text.addAll(parser.parse(textBlock));
            }

            if (codeBLock != null) {
                text.add(new Code(codeBLock));
            }
        }

        return text;
    }
}
