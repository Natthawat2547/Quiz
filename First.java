public class First {

    // ตัวแปรสำหรับค่าน้ำ ค่าไฟ และมิเตอร์
    public static int waterM, electM;
    public static int currentWaterMeter, lastWaterMeter;
    public static int currentElectMeter, lastElectMeter;

    // ฟังก์ชันคำนวณค่าน้ำ
    public static int calculateWaterBill() {
        if (currentWaterMeter < lastWaterMeter) {
            throw new IllegalArgumentException("Current Water Meter must be greater than Last Water Meter");
        }
        waterM = (currentWaterMeter - lastWaterMeter) * 5;
        return waterM;
    }

    // ฟังก์ชันคำนวณค่าไฟ
    public static int calculateElectBill() {
        if (currentElectMeter < lastElectMeter) {
            throw new IllegalArgumentException("Current Electric Meter must be greater than Last Electric Meter");
        }
        electM = (currentElectMeter - lastElectMeter) * 6;
        return electM;
    }

    // ฟังก์ชันคำนวณค่าใช้จ่ายรวมตามประเภทห้อง
    public static int calculateResultBill(String roomType) {
        int baseRate;
        int resultBill = 0;

        switch (roomType.toUpperCase()) {
            case "S":
                baseRate = 1500; // ห้องประเภท S
                break;
            case "D":
                baseRate = 2000; // ห้องประเภท D
                break;
            default:
                throw new IllegalArgumentException("Invalid room type. Please use 'S' or 'D'.");
        }

        resultBill = baseRate + calculateElectBill() + calculateWaterBill();
        return resultBill;
    }

    public static void main(String[] args) {
        try {
            // ตั้งค่ามิเตอร์น้ำและไฟ
            currentElectMeter = 50;
            lastElectMeter = 20;

            currentWaterMeter = 100;
            lastWaterMeter = 80;

            // คำนวณบิลแยก
            int waterBill = calculateWaterBill();
            int electricBill = calculateElectBill();
            int totalBill = calculateResultBill("D");

            // แสดงผลบิลแยกและรวม
            System.out.println("Water bill: " + waterBill + " THB");
            System.out.println("Electric bill: " + electricBill + " THB");
            System.out.println("Total bill: " + totalBill + " THB");
        } catch (IllegalArgumentException e) {
            // จัดการข้อผิดพลาดและแสดงข้อความ
            System.err.println("Error: " + e.getMessage());
        }
    }
}
