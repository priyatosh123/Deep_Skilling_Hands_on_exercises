package factory;


public abstract class DocumentFactory {

    public abstract Document createDocument();

    // Template method: can add shared behavior around creation
    public Document getDocument() {
        Document doc = createDocument();
        System.out.println("Created: " + doc.getType());
        return doc;
    }
}
