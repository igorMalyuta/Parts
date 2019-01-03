package com.vegas.parts.model;

public class Computer {

    PartType cpu;
    PartType ram;
    PartType hdd;
    PartType motherboard;

    public void setCpu(PartType cpu) {
        if (cpu == PartType.CPU)
            this.cpu = cpu;
    }

    public void setRam(PartType ram) {
        if (ram == PartType.RAM)
            this.ram = ram;
    }

    public void setHdd(PartType hdd) {
        if(hdd == PartType.HDD)
            this.hdd = hdd;
    }

    public void setMotherboard(PartType motherboard) {
        if(motherboard == PartType.MOTHERBOARD)
            this.motherboard = motherboard;
    }

    public boolean readyForAssembly() {
        return cpu != null && ram != null && hdd != null && motherboard != null;
    }
}
