package quadraticequation;

@FunctionalInterface
public interface IQuadratic<T, U, V, R1, R2> {
    Pair<R1, R2> solveQuadraticEquation(T t, U u, V v);
}
