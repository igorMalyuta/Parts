package com.vegas.parts.model;

public enum PartType {

    CPU,
    RAM,
    HDD,
    MOTHERBOARD,
    CASE,
    SSD,
    GPU,
    SOUND_CARD;


    public static boolean isNecessary(PartType part) {
        switch(part) {
            case CPU:
            case RAM:
            case HDD:
            case MOTHERBOARD:
            case CASE: return true;

            case SSD:
            case GPU:
            case SOUND_CARD: return false;

            default: return false;
        }
    }
}
