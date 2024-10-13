import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @description:
 * 测试类用于验证 Solution9 的 possibleBipartition 方法的正确性。
 *
 * 测试用例设计原则：
 * - 等价类划分原则：
 *   1. 正常情况：可以将人分为两组的情况。
 *   2. 边界情况：最小人数1人，没有讨厌关系。
 *   3. 异常情况：不能将所有人分为两组的情况。
 *   4. 空数据情况：没有讨厌关系。
 */
public class Solution9_Test {

    // 测试用例1：正常情况，可以将人分为两组
    // 测试目标：验证当存在可行的分组时，返回值应为 true。
    // 用例输入：n = 4, dislikes = [[1,2], [1,3], [2,4]]
    @Test
    public void testPossibleBipartition_CanPartition() {
        Solution9 solution = new Solution9();
        int n = 4;
        int[][] dislikes = {{1, 2}, {1, 3}, {2, 4}};
        boolean result = solution.possibleBipartition(n, dislikes);
        assertTrue(result, "应返回 true，因为可以将人分成两组：group1[1, 4], group2[2, 3]");
    }

    // 测试用例2：不能分组的情况
    // 测试目标：验证当不能将所有人分为两组时，返回值应为 false。
    // 用例输入：n = 3, dislikes = [[1,2], [1,3], [2,3]]
    @Test
    public void testPossibleBipartition_CannotPartition() {
        Solution9 solution = new Solution9();
        int n = 3;
        int[][] dislikes = {{1, 2}, {1, 3}, {2, 3}};
        boolean result = solution.possibleBipartition(n, dislikes);
        assertFalse(result, "应返回 false，因为人不能分为两组，因 [2, 3] 两人互相不喜欢。");
    }

    // 测试用例3：边界情况，最少人数
    // 测试目标：验证当只有一个人时，返回值应为 true。
    // 用例输入：n = 1, dislikes = []
    @Test
    public void testPossibleBipartition_MinimumInput() {
        Solution9 solution = new Solution9();
        int n = 1;
        int[][] dislikes = {};
        boolean result = solution.possibleBipartition(n, dislikes);
        assertTrue(result, "应返回 true，因为只有一个人，无讨厌关系。");
    }

    // 测试用例4：没有讨厌关系的情况
    // 测试目标：验证当没有讨厌关系时，返回值应为 true。
    // 用例输入：n = 5, dislikes = []
    @Test
    public void testPossibleBipartition_NoDislikes() {
        Solution9 solution = new Solution9();
        int n = 5;
        int[][] dislikes = {};
        boolean result = solution.possibleBipartition(n, dislikes);
        assertTrue(result, "应返回 true，因为没有讨厌关系，所有人可以分为任意两组。");
    }

    // 测试用例5：复杂不能分组的情况
    // 测试目标：验证在复杂的讨厌关系下，不能分为两组的情况。
    // 用例输入：n = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
    @Test
    public void testPossibleBipartition_ComplexCannotPartition() {
        Solution9 solution = new Solution9();
        int n = 5;
        int[][] dislikes = {{1, 2}, {2, 3}, {3, 4}, {4, 5}, {1, 5}};
        boolean result = solution.possibleBipartition(n, dislikes);
        assertFalse(result, "应返回 false，因为讨厌关系形成了循环，无法分组。");
    }
}
