package cn.kanyun;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.PropertySource;
import org.springframework.util.StringUtils;

/**
 * 自定义随机启动端口,由于springboot提供的随机启动端口设置[0或者${random.int}],都会导致在Eureka上注册的实例端口与
 * 真实服务端口不一致,因此需要自定义PropertySource
 * https://blog.csdn.net/qq_18748427/article/details/79528794
 * @author KANYUN
 */
@Slf4j
public class RandomServerPortPropertySource extends PropertySource<RandomServerPort> {

    /**
     * Name of the random {@link PropertySource}.
     */
    public static final String RANDOM_SERVER_PORT_PROPERTY_SOURCE_NAME = "randomServerPort";

    private static final String PREFIX = "randomServerPort.";

    public RandomServerPortPropertySource(String name) {
        super(name, new RandomServerPort());
    }

    public RandomServerPortPropertySource() {
        this(RANDOM_SERVER_PORT_PROPERTY_SOURCE_NAME);
    }

    public RandomServerPortPropertySource(String name, RandomServerPort source) {
        super(name, source);
    }

    @Override
    public Object getProperty(String name) {
        if (!name.startsWith(PREFIX)) {
            return null;
        }
        if (log.isTraceEnabled()) {
            log.trace("Generating randomServerPort property for '" + name + "'");
        }
        return getRandomServerPortValue(name.substring(PREFIX.length()));
    }

    private Object getRandomServerPortValue(String type) {
        String range = getRange(type, "value");
        if (range != null) {
            return getNextValueInRange(range);
        }
        return null;
    }

    private String getRange(String type, String prefix) {
        if (type.startsWith(prefix)) {
            int startIndex = prefix.length() + 1;
            if (type.length() > startIndex) {
                return type.substring(startIndex, type.length() - 1);
            }
        }
        return null;
    }

    private int getNextValueInRange(String range) {
        String[] tokens = StringUtils.commaDelimitedListToStringArray(range);
        int start = Integer.parseInt(tokens[0]);
        if (tokens.length == 1) {
            return getSource().nextValue(start);
        }
        return getSource().nextValue(start, Integer.parseInt(tokens[1]));
    }
}