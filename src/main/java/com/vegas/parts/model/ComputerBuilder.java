package com.vegas.parts.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ComputerBuilder {

    private ComputerBuilder(){}

    public static int assemblyCount(List<Part> parts) {
        int cpuSum =
                parts.stream().filter(p -> p.getType() == PartType.CPU).mapToInt(Part::getQuantity).sum();

        int ramSum =
                parts.stream().filter(p -> p.getType() == PartType.RAM).mapToInt(Part::getQuantity).sum();

        int hddSum =
                parts.stream().filter(p -> p.getType() == PartType.HDD).mapToInt(Part::getQuantity).sum();

        int mbSum =
                parts.stream().filter(p -> p.getType() == PartType.MOTHERBOARD).mapToInt(Part::getQuantity).sum();

        int caseSum =
                parts.stream().filter(p -> p.getType() == PartType.CASE).mapToInt(Part::getQuantity).sum();

        return Collections.min(Arrays.asList(cpuSum, ramSum, hddSum, mbSum, caseSum));
    }
}
