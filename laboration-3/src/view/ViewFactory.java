  package view;

public class ViewFactory {
	
    public View createView(String type) {
        switch (type.toLowerCase()) {
            case "gui":
                return new GUIView();
            case "cli":
                return new CLIView();
            default:
                throw new IllegalArgumentException("Unknown view type");
        }
    }
}
