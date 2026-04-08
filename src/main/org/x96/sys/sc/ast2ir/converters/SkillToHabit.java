package org.x96.sys.sc.ast2ir.converters;

import org.x96.sys.sc.ast.Skill;
import org.x96.sys.sc.ast2ir.contracts.ToIr;
import org.x96.sys.sc.ir.Habit;
import org.x96.sys.sc.ir.Pulse;

public class SkillToHabit implements ToIr<Skill, Habit> {
    @Override
    public Habit convert(Skill skill) {
        Pulse[] pulses = new Pulse[skill.ethics().length];
        for (int i = 0; i < pulses.length; i++) {
            pulses[i] = new EthicsToPulse().convert(skill.ethics()[i]);
        }
        return new Habit(new PrimorToId().convert(skill.primor()), pulses);
    }
}
