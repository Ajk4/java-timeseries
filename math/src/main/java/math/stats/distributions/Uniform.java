/*
 * Copyright (c) 2017 Jacob Rachiele
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software
 * and associated documentation files (the "Software"), to deal in the Software without restriction
 * including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense
 * and/or sell copies of the Software, and to permit persons to whom the Software is furnished to
 * do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR
 * PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT,
 * TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE
 * USE OR OTHER DEALINGS IN THE SOFTWARE.
 *
 * Contributors:
 *
 * Jacob Rachiele
 */

package math.stats.distributions;

import lombok.EqualsAndHashCode;
import smile.math.Random;

@EqualsAndHashCode
public final class Uniform implements Distribution {

    private final double a;
    private final double b;
    private final Random random = new Random();

    public Uniform(final double a, final double b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public double rand() {
        return random.nextDouble(a, b);
    }

    @Override
    public double quantile(double prob) {
        if (prob < 0.0 || prob > 1.0) {
            throw new IllegalArgumentException("The probability must be between 0 and 1 (inclusive).");
        }
        return prob * (b - a) + a;
    }

    @Override
    public String toString() {
        return "Uniform(" + Double.toString(a) + ", " + Double.toString(b) + ")";
    }
}
