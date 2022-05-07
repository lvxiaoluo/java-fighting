package org.example.sentinel;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.Tracer;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRule;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRuleManager;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lvle
 * @date 2022-05-07 09:38
 */
public class DeGradeSentinelTest {
    public static void main(String[] args) {
        // 定义降级规则
        List<DegradeRule> rules = new ArrayList<>();
        DegradeRule rule = new DegradeRule();
        rule.setResource("tutorial");
        // 5s内异常不得超出10
        rule.setCount(10);
        rule.setGrade(RuleConstant.DEGRADE_GRADE_EXCEPTION_COUNT);
        rule.setLimitApp("default");
        rules.add(rule);
        DegradeRuleManager.loadRules(rules);

        Entry entry = null;
        try {
            entry = SphU.entry("key");
            // 业务代码在这里
        } catch (Throwable t) {
            // 记录异常
            if (!BlockException.isBlockException(t)) {
                Tracer.trace(t);
            }
        } finally {
            if (entry != null) {
                entry.exit();
            }
        }

    }
}
