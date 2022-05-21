package by.gsu.training.final1;

public class Trip {
    private final int BET = 1270;
    private String fio = "Иванов Иван";
    private int expenses = 950;
    private int days = 10;

    //конструкторы
    public Trip(){
    }

    public Trip(String fio, int expenses, int days){
        this.fio = fio;
        this.expenses = expenses;
        this.days = days;
    }

    public Trip (int days){
        this.days = days;
    }

    public Trip(Trip  t){
        this(t.fio, t.expenses, t.days); // должен быть только первым!
    }

    //методы

    public int getBET() {
        return BET;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public int getExpenses() {
        return expenses;
    }

    public void setExpenses(int expenses) {
        this.expenses = expenses;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public int getTotal(){ // Ошибка №1 ( убрал параметры из метода )
        int total;
        total = expenses + (BET * days);
        return total;
    }


    public static String toByn(int t){ /* Ошибка №2 (сделал правильное отображение BYN)
       Возможно этот способ слишком мудрённый, и есть более простой перевод копеек с int в String,
       но он рабочий*/
        String s1 = Integer.toString(t / 100);
        String s2 = Integer.toString(t % 100);
        if ((t % 100) < 10 ) {
            s2 = '0' + Integer.toString(t % 100);
        } else if ( Integer.toString(t % 100).length() < 2){
            s2 = Integer.toString(t % 100) + '0';
        }
        String s = s1 + '.' + s2;
        return s;
    }

    public void show() { // Ошибка №3, сделал вывод полей, а не возвращение строкового предсталения
        System.out.println("Аккаунт= " + fio + '\n' +
                "Ставка= " + toByn(BET) + '\n' +
                "Транспортные расходы= " + toByn(expenses) + '\n' +
                "Кол-во дней= " + days + '\n' +
                "Общие расходы= " + toByn(getTotal()));
    }

    @Override
    public String toString() { // Ошибка №4, убрал в строковом представлении константное поле BET
        return  fio  + ';' +
                toByn(expenses) + ';' +
                days + ';' +
                toByn(getTotal());
    }
}
