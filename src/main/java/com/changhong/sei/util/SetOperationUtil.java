package com.changhong.sei.util;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 实现功能: LIST的集合运算工具类
 *
 * @author 王锦光 wangjg
 * @version 2020-03-01 10:54
 */
public class SetOperationUtil {
    /**
     * 获取两个集合的交集
     * @param first 第一个集合
     * @param second 第二个集合
     * @param <T> 类型
     * @return 交集
     */
    public static <T> List<T> intersection(List<T> first, List<T> second){
        if (Objects.isNull(first) || Objects.isNull(second)) {
            return new ArrayList<>();
        }
        Set<T> firstSet = new LinkedHashSet<>(first);
        Set<T> secondSet = new LinkedHashSet<>(second);
        return firstSet.stream().filter(secondSet::contains).distinct().collect(Collectors.toList());
    }

    /**
     * 获取两个集合的差集（first-second）
     * @param first 第一个集合
     * @param second 第二个集合
     * @param <T> 类型
     * @return 差集
     */
    public static <T> List<T> difference(List<T> first, List<T> second){
        if (Objects.isNull(first) || Objects.isNull(second)) {
            return new ArrayList<>();
        }
        Set<T> firstSet = new LinkedHashSet<>(first);
        Set<T> secondSet = new LinkedHashSet<>(second);
        return firstSet.stream().filter(item -> !secondSet.contains(item)).distinct().collect(Collectors.toList());
    }

    /**
     * 获取两个集合的并集（去重）
     * @param first 第一个集合
     * @param second 第二个集合
     * @param <T> 类型
     * @return 并集
     */
    public static <T> List<T> union(List<T> first, List<T> second){
        if (Objects.isNull(first) || Objects.isNull(second)) {
            return new ArrayList<>();
        }
        Set<T> unionSet = new LinkedHashSet<>();
        unionSet.addAll(first);
        unionSet.addAll(second);
        return new ArrayList<>(unionSet);
    }
}
