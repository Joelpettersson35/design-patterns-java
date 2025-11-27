  package view;

public class ViewFactory {
	
    public View createView(String type) {
        switch (type.toLowerCase()) {
            case "1":
                return new GUIView();
            case "2":
                return new CLIView();
            default:
                throw new IllegalArgumentException("Unknown view type");
        }
    }
}
