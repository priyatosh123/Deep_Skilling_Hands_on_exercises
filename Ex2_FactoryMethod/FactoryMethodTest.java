package factory;


public class FactoryMethodTest {

    public static void main(String[] args) {
        DocumentFactory[] factories = {
            new WordDocumentFactory(),
            new PdfDocumentFactory(),
            new ExcelDocumentFactory()
        };

        for (DocumentFactory factory : factories) {
            Document doc = factory.getDocument();
            doc.open();
            doc.save();
            System.out.println();
        }
    }
}
