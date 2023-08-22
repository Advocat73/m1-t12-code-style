import java.util.Scanner;

public class DepositCalculator  {
    double calculateComplexPercentFunction(double amount, double percent, int period) { //Function лучше удалить
        //третий параметр лучше назвать depositPeriod исходя из логики кода
        double pay = amount * Math.pow((1 + percent / 12), 12 * period);
        //1 + 0.06 / 12 = 1.005 второй аргумент метода pow всегда double, поэтому нагляднее, чтобы
        // один из аргументов тоже был double, например 12.0
        return ronudResult(pay, 2);
    }

    double calculateSimplePercentFunction(double doubleAmount, double doubleYearRate, int depositPeriod) {
        //Function лучше удалить, в названии переменных содержится тип
        //переменная doubleYearRate всегда равна 0.06, может быть убрана из аргументов
        return ronudResult(doubleAmount + doubleAmount * doubleYearRate * depositPeriod, 2);
        //лучше выражение в скобках предрассчитать строкой выше: 1. для читабельности 2. для симметрии с
        //методом calculateComplexPercent
    }

    double ronudResult(double value, int places) {//метод вычисляет итоговую сумму вклада, ronud - не понял,
        // если имелся ввиду round - лучше заменить
        //value - лучше назвать информативно;
        // plases всегда равна 2, можно убрать из параметров в код метода

        double ScaLe = Math.pow(10, places); //лучше с маленькой буквы, м.б. подходит level
        return Math.round(value * ScaLe) / ScaLe;
    }

    void doImportantJob() { //не информативное имя метода
        int period;
        int action;
        int amount;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:");
        amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();
        double outDoubleVar = 0; //тип переменой в имени, неинформативное имя
        if (action == 1)
            outDoubleVar = calculateComplexPercentFunction(amount, 0.06, period);
        else if (action == 2)
            outDoubleVar = calculateSimplePercentFunction(amount, 0.06, period);
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + outDoubleVar);
    }
}
