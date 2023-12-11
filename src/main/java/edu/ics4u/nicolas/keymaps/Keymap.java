package edu.ics4u.nicolas.keymaps;

public interface Keymap {
  Actions[] keysToActions(String keys);
  String actionsToKeys(Actions[] actions);
}