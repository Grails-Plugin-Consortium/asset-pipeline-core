package asset.pipeline.utils.net


import java.util.regex.Matcher
import java.util.regex.Pattern


/**
 * @author Ross Goldberg
 */
final class Urls {

    /**
     * URL starts with either {@code "/"} or a <a href="https://tools.ietf.org/html/std66">URI scheme</a> followed by {@code "/"}
     */
    static final Pattern ABSOLUTE_URL_PATTERN = ~/^(?:\p{L}[\p{L}\d+-.]*:)?\//

    /**
     * URL starts with a <a href="https://tools.ietf.org/html/std66">URI scheme</a>
     */
    static final Pattern URL_SCHEME_WITH_COLON_PATTERN = ~/^\p{L}[\p{L}\d+-.]*:/

    /**
     * URL starts with a <a href="https://tools.ietf.org/html/std66">URI scheme</a>
     */
    static final Pattern URL_SCHEME_SANS_COLON_PATTERN = ~/^\p{L}[\p{L}\d+-.]*(?=:)/


    /**
     * URL starts with either {@code "/"} or a <a href="https://tools.ietf.org/html/std66">URI scheme</a> followed by {@code "/"}
     */
    static boolean isAbsolute(final String url) {
        ABSOLUTE_URL_PATTERN.matcher(url).find()
    }

    /**
     * URL does not start with either {@code "/"} or a <a href="https://tools.ietf.org/html/std66">URI scheme</a> followed by {@code "/"}
     */
    static boolean isRelative(final String url) {
        ! isAbsolute(url)
    }


    /**
     * @returns <a href="https://tools.ietf.org/html/std66">URI scheme</a>, including trailing colon, if present;
     * otherwise, returns {@code defaultScheme}, which defaults to {@code null}
     */
    static String getSchemeWithColon(final String url, final String defaultScheme = null) {
        final Matcher m = URL_SCHEME_WITH_COLON_PATTERN.matcher(url)
        m.find() \
            ? m.group()
            : defaultScheme
    }


    private Urls() {}
}
