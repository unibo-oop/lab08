/**
 *
 */

package it.unibo.mvc.view;

import it.unibo.mvc.api.DrawNumberView;
import it.unibo.mvc.api.DrawNumberController;
import it.unibo.mvc.api.DrawResult;

import static java.lang.System.out;

/**
 * This class implements a view that can write on any PrintStream.
 */
public final class DrawNumberStandardOutputView implements DrawNumberView {

    /**
     * Builds a new {@link DrawNumberStandardOutputView}.
     */
    public DrawNumberStandardOutputView() {
        /*
         * This constructor is here to write the Javadoc and avoid Java 21+:
         * `warning: use of default constructor, which does not provide a comment`
         */
    }

    @Override
    public void setController(final DrawNumberController observer) {
        /*
         * This UI is output only.
         */
    }

    @Override
    public void start() {
        /*
         * PrintStreams are always ready.
         */
    }

    @Override
    public void result(final DrawResult res) {
        out.println(res.getDescription());
    }
}
