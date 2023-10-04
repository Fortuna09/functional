package br.edu.mg.unifal.functionalInterface;


import java.util.Objects;
import java.util.function.BiPredicate;

@FunctionalInterface
public interface TriPredicate<T, U, V> {
    boolean test(T var1, U var2, V v );

    default TriPredicate<T, U, V> and(TriPredicate<? super T, ? super U, ? super V> other) {
        Objects.requireNonNull(other);
        return (t, u, v) -> {
            return this.test(t, u, v) && other.test(t, u, v);
        };
    }

    default TriPredicate<T, U, V> negate() {
        return (t, u, v) -> {
            return !this.test(t, u, v);
        };
    }

    default TriPredicate<T, U, V> or(TriPredicate<? super T, ? super U, ? super V> other) {
        Objects.requireNonNull(other);
        return (t, u, v) -> {
            return this.test(t, u, v) || other.test(t, u, v);
        };
    }
}
