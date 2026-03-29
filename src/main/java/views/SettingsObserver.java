package views;

public interface SettingsObserver {
  void settingsChanged(String propertyName, Object oldValue, Object newValue);
}
