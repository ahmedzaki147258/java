package day4.LibrarySystem.LibraryManagementSystem;

public class Magazine extends LibraryItem {
    private int edition;

    public Magazine(String title, int stock, int edition) { super(title, stock, "Magazine"); this.edition = edition; }

    public int getEditionNumber() { return edition; }

    @Override
    public String getItemDetails() {
        return "MagazineData [ID=" + getId() + ", Title=" + getTitle() + ", Stock" + getStock() + ", Edition=" + edition + "]";
    }
}
