package lambdasinaction.generics;

// generics/CuriouslyRecurringGeneric.java

/**
 * 没有自限定边界
 * @param <T>
 */
class GenericType<T> {}

/**
 * 这可以按照 Jim Coplien 在 C++ 中的古怪的循环模版模式的命名方式，称为古怪的循环泛型（CRG）。
 * “古怪的循环”是指 类 相当古怪地 出现在 它自己的基类 中这一事实。 为了理解其含义，努力大声说：
 * “我在创建一个新类，它继承自一个泛型类型，这个泛型类型接受我的类的名字作为其参数。”
 * 当给出导出类的名字时，这个泛型基类能够实现什么呢？好吧，Java 中的泛型关乎参数和返回类型，
 * 因此它能够产生使用导出类作为其参数和返回类型的基类
 */
public class CuriouslyRecurringGeneric extends GenericType<CuriouslyRecurringGeneric> {}

