package org.example.sentinel;

/**
 * @author lvle
 * @date 2022-05-06 23:05
 */
import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphO;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;

import java.util.ArrayList;
import java.util.List;

public class SentinelTest {
    public static void main(String[] args) {
        // 配置规则
        List<FlowRule> rules = new ArrayList<>();
        FlowRule rule = new FlowRule();
        rule.setResource("tutorial");
        // QPS 不得超出 1
        rule.setCount(1);
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        rule.setLimitApp("default");
        rules.add(rule);
        // 加载规则
        FlowRuleManager.loadRules(rules);
//        sphThrow();
        sphBoolean();
    }

    private static void sphThrow() {
        // 下面开始运行被限流作用域保护的代码
        while (true) {
            Entry entry = null;
            try {
                entry = SphU.entry("tutorial");
                System.out.println("hello world");
            } catch (BlockException e) {
                System.out.println("blocked");
            } finally {
                if (entry != null) {
                    entry.exit();
                }
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {}
        }
    }
    private static void sphBoolean(){
        // 运行被限流作用域保护的代码
        while (true) {
            if (SphO.entry("tutorial")) {
                try {
                    System.out.println("hello world");
                } finally {
                    SphO.exit();
                }
            } else {
                System.out.println("blocked");
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {}
        }
    }
}
