package FirstLab;

import java.util.Arrays;

public class ListData {
    private final char[] name    = new char[20];
    private final char[] address = new char[50];

    public ListData(char[] name, char[] address) {
        System.arraycopy(name, 0, this.name, 0, name.length);
        System.arraycopy(address, 0, this.address, 0, address.length);
    }

    public ListData(ListData listData) {
        System.arraycopy(listData.name, 0, this.name, 0, listData.name.length);
        System.arraycopy(listData.address, 0, this.address, 0, listData.address.length);
    }

    public char[] getName() {
        return name;
    }

    public void setName(char[] name) {
        System.arraycopy(name, 0, this.name, 0, name.length);
    }

    public char[] getAddress() {
        return address;
    }

    public void setAddress(char[] address) {
        System.arraycopy(address, 0, this.address, 0, address.length);
    }

    private String getStrFromChar(char[] chars) {
        StringBuilder sb = new StringBuilder();
        for (char c : chars) if (c != 0) sb.append(c);
        return sb.toString();
    }

    public ListData copy() {
        return new ListData(this);
    }

    @Override public String toString() {
        return "Name: " + getStrFromChar(name) + ", address: " + getStrFromChar(address);
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ListData)) return false;
        ListData listData = (ListData) o;
        return Arrays.equals(name, listData.name) && Arrays.equals(address, listData.address);
    }

    @Override public int hashCode() {
        int result = Arrays.hashCode(name);
        result = 31 * result + Arrays.hashCode(address);
        return result;
    }
}
