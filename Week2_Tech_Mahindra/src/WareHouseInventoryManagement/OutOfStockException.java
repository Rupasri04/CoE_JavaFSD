package WareHouseInventoryManagement;
class OutOfStockException extends Exception {
    public OutOfStockException(String message) {
        super(message);
    }
}

class InvalidLocationException extends Exception {
    public InvalidLocationException(String message) {
        super(message);
    }
}
