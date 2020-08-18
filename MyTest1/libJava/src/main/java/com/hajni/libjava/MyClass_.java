package com.hajni.libjava;

public class MyClass_ {

//    ArrayList<String> list = new ArrayList<>();
//
//        list.add("Java");
//        list.add("Python");
//        list.add("Javascript");
//        list.add(1,"C");
//        list.add("SQL");
//
//        for (int i = 0; i < list.size();i++){
//        System.out.println(list.get(i));

//    // 시간관련 time
//    LocalDate currDate = LocalDate.now();
//        System.out.println("current Dae :" + currDate);
//
//    LocalDate targeDate = LocalDate.of(2024,5,10);
//        System.out.println("target Date : " + targeDate);
//        System.out.println();
//
//    LocalTime currTime = LocalTime.now();
//        System.out.println("current Time : " + currTime);
//
//    LocalTime targetTime = LocalTime.of(23,30,0,0);
//        System.out.println("taget Time : " + targetTime);
//
//    LocalDateTime currDateTime = LocalDateTime.now();
//        System.out.println("current : " + currDateTime);
//
//    LocalDateTime targetDateTime = LocalDateTime.of(2024,5,10,23,30);
//        System.out.println("target : " + targetDateTime);
//
//    ZonedDateTime utcDateTime = ZonedDateTime.now(ZoneId.of("UTC"));
//        System.out.println("UTC : " + utcDateTime);
//
//    ZonedDateTime newyorkDateTime = ZonedDateTime.now(ZoneId.of("America/New_York"));
//        System.out.println("new york : " + newyorkDateTime);
//
//    LocalDateTime now = LocalDateTime.now();
//        System.out.println(now);
//
//    String strDateTime = now.getYear() + "/";
//    strDateTime += now.getMonth() + "/";
//    strDateTime += now.getDayOfMonth() + " ";
//        System.out.println(strDateTime);
//
//    LocalDate nowDate = now.toLocalDate();
//        if (nowDate.isLeapYear()){
//        System.out.println("Yes Leap Year, 29");
//    }else {
//        System.out.println("Not Leap Year, 28");
//    }
//
//    LocalDateTime newDate = now.plusYears(1)
//            .minusMonths(2).plusDays(4).plusHours(2);
//        System.out.println(newDate);
//
//    LocalDateTime startDateTime = LocalDateTime.of(2023,7,31,18,0,0);
//        System.out.println("start date " + startDateTime);
//
//    LocalDateTime endDateTime = LocalDateTime.of(2024,3,31,18,0,0);
//        System.out.println("end date " + endDateTime);
//
//        if (startDateTime.isBefore(endDateTime)){
//        System.out.println("ing...");
//    }else if (startDateTime.isEqual(endDateTime)){
//        System.out.println("same");
//    }else if (startDateTime.isAfter(endDateTime)){
//        System.out.println("end");
//    }
//
//    //남은시간
//    long remainYear = startDateTime.until(endDateTime, ChronoUnit.YEARS);
//        System.out.println(remainYear);
//
//    long remainMonth = startDateTime.until(endDateTime, ChronoUnit.MONTHS);
//        System.out.println(remainMonth);
//
//    long remainDay = startDateTime.until(endDateTime, ChronoUnit.DAYS);
//        System.out.println(remainDay);
//
//    long remainHour = startDateTime.until(endDateTime, ChronoUnit.HOURS);
//        System.out.println(remainHour);
//
//    long remainMinute = startDateTime.until(endDateTime, ChronoUnit.MINUTES);
//        System.out.println(remainMinute);
//
//    long remainSecond = startDateTime.until(endDateTime, ChronoUnit.SECONDS);
//        System.out.println(remainSecond);
//
//    remainYear = ChronoUnit.YEARS.between(startDateTime,endDateTime);
//
//    DateTimeFormatter formatter;
//    LocalDate localDate;
//
//    localDate = LocalDate.parse("2024-05-21");
//        System.out.println(localDate);
//
//    formatter = DateTimeFormatter.ISO_LOCAL_DATE;
//    localDate = LocalDate.parse("2024-05-21", formatter);
//        System.out.println(localDate);
//
//    formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
//    localDate = LocalDate.parse("2024/05/21", formatter);
//        System.out.println(localDate);
//
//    formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
//    localDate = LocalDate.parse("2024.05.21", formatter);
//        System.out.println(localDate);



//    // formatting
//    double num = 1234567.89;
//
//    DecimalFormat df = new DecimalFormat("0");
//        System.out.println(df.format(num));
//
//    df = new DecimalFormat("0.0");
//        System.out.println(df.format(num));
//
//    df = new DecimalFormat("00000000000.00000");
//        System.out.println(df.format(num));
//
//    df = new DecimalFormat("#");
//        System.out.println(df.format(num));
//
//    df = new DecimalFormat("#.#");
//        System.out.println(df.format(num));
//
//    df = new DecimalFormat("######.########");
//        System.out.println(df.format(num));
//
//    df = new DecimalFormat("#.0");
//        System.out.println(df.format(num));
//
//    df = new DecimalFormat("+#.0");
//        System.out.println(df.format(num));
//
//    df = new DecimalFormat("-#.0");
//        System.out.println(df.format(num));
//
//    df = new DecimalFormat("#,###.0");
//        System.out.println(df.format(num));
//
//    df = new DecimalFormat("0.0E0");
//        System.out.println(df.format(num));
//
//    df = new DecimalFormat("+#," +
//                                   "" +
//                                   "" +
//                                   "### ; -#,###");
//        System.out.println(df.format(num));
//
//    df = new DecimalFormat("#.# %");
//        System.out.println(df.format(num));
//
//    String id = "Java";
//    String name = "Mike";
//    String tel = "010-1234-5678";
//    String gender = "male";
//
//    String id2 = "Python";
//    String name2 = "Harry";
//    String tel2 = "010-1111-3333";
//    String gender2 = "female";
//
//    String text = "user Id : {0} \nuser name : {1} \ngender : {3} \nuser tel : {2}";
//
//    String result1 = MessageFormat.format(text, id, name,tel, gender);
//        System.out.println(result1);
//
//    String result2 = MessageFormat.format(text, id2, name2,tel2, gender2);
//        System.out.println(result2);



//    // "2020-05-14 11:12:43"
//    Date now = new Date();
//    String strNow1 = now.toString();
//        System.out.println(strNow1);
//
//    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:sss");
//    String strNow2 = sdf.format(now);
//        System.out.println(strNow2);
//
//    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:sss");
//    String strNow3 = sdf2.format(now);
//        System.out.println(strNow3);
//
//    Calendar now2 = Calendar.getInstance();
//    int year = now2.get(Calendar.YEAR);
//    int month = now2.get(Calendar.MONTH) + 1;
//    int day = now2.get(Calendar.DAY_OF_MONTH);
//
//    int week = now2.get(Calendar.DAY_OF_WEEK);
//    String strWeek = null;
//        switch (week){
//        case Calendar.MONTH:
//            strWeek = "Mon";
//            break;
//        case Calendar.TUESDAY:
//            strWeek = "Tue";
//            break;
//        case Calendar.WEDNESDAY:
//            strWeek = "Wed";
//            break;
//        case Calendar.THURSDAY:
//            strWeek = "Thu";
//            break;
//        case Calendar.FRIDAY:
//            strWeek = "Fri";
//            break;
//        case Calendar.SUNDAY:
//            strWeek = "Sun";
//            break;
//    }
//        System.out.println(strWeek);
//        System.out.println(week);
//
//    int AmPm = now2.get(Calendar.AM_PM);
//    String strAmPm = null;
//        if (AmPm == Calendar.AM){
//        strAmPm = "AM";
//    }else {
//        strAmPm = "PM";
//    }
//        System.out.println(AmPm);
//        System.out.println(strAmPm);
//
//    int hour = now2.get(Calendar.HOUR);
//    int minute = now2.get(Calendar.MINUTE);
//    int second = now2.get(Calendar.SECOND);
//
//        System.out.println(year + "-" + month + "-" + day + " " + hour + ":" + minute + ":" + second);


//    int v1 = Math.abs(-5);
//    double v2 = Math.abs(-3243.234);
//    float v3 = Math.abs(-23111.455f);
//    long v4 = Math.abs(-324234L);
//
//        System.out.println(v1 + ", " + v2 + ", " + v3 + ", " + v4);
//
//    double a1 = Math.ceil(5.3);
//    double a2 = Math.ceil(-5.3);
//        System.out.println(a1);
//        System.out.println(a2);
//
//    double a3 = Math.floor(5.7);
//    double a4 = Math.floor(-5.7);
//        System.out.println(a3);
//        System.out.println(a4);
//
//    int b1 = Math.max(1,10);
//        System.out.println(b1);
//
//    int b2 = Math.min(-239,-224);
//        System.out.println(b2);
//
//    double c = Math.random();//0에서 1사이의 숫자랜덤으로
//        System.out.println(c);
//    c = Math.random()*10;
//        System.out.println(c);
//    c = Math.random()*100;
//        System.out.println(c);
//
//    long v14 = Math.round(5.6);//반올림
//    long v15 = Math.round(5.1);
//        System.out.println(v14);
//        System.out.println(v15);
//
//    // 0 <= Math.random()     < 1
//    // 0 <= Math.random() * 6 < 6
//    // 0 <= (int)Math.random() * 6 < 6
//    int num = (int)(Math.random() * 45)+ 1 ;
//        System.out.println(num);



//    String text = "red/green/blue/white/black";
//    StringTokenizer st = new StringTokenizer(text, "/");
//    int countTokens = st.countTokens();
//        System.out.println(countTokens);
//        for (int i = 0; i < countTokens; i ++){
//        String token = st.nextToken();
//        System.out.println(token);
//    }
//
//    StringTokenizer st2 = new StringTokenizer(text, "/");
//        while (st2.hasMoreElements()){
//        String token = st2.nextToken();
//        System.out.println(token);
//    }
//
//    StringBuilder sb = new StringBuilder();
//        sb.append("Java ");
//        sb.append("Programming Class");
//        sb.append(" Bye");
//        sb.insert(5,"language ");
//        System.out.println(sb);
//
//        sb.replace(0,4,"Python");
//        System.out.println(sb);
//
//        System.out.println(sb.length());
//
//    String str = sb.toString();

//    System.out.println("concat() text : " + "abc.".concat("def"));
//
//    String strVar = new String("hello");
//    String strVar2 = "hello";
//
//    String concatStr = strVar.concat(strVar2);
//        System.out.println(concatStr);
//
//        if (strVar == strVar2){
//        System.out.println("the same String");
//    }else {
//        System.out.println("different");
//    }
//
//        if (strVar.compareTo(strVar2) == 0){
//        System.out.println("the same String");
//    }else {
//        System.out.println("different");
//    }
//
//        if (strVar.equals(strVar2)){
//        System.out.println("the same String");
//    }else {
//        System.out.println("different");
//    }
//
//    String subject = "java programming language class";
//    int location = subject.indexOf("ja");
//        System.out.println(location);
//
//        if(subject.indexOf("dd") != -1){
//        System.out.println("exists");
//    }else {
//        System.out.println("no word");
//    }
//
//        System.out.println(subject.substring(0,4));
//        System.out.println(subject.substring(5,16));
//
//    String ssn = "45684633216";
//    int len1 = ssn.length();
//    int len2 = subject.length();
//
//        System.out.println(len1);
//        System.out.println(len2);
//
//        if ("programming".compareTo(" programming") == 0){
//        System.out.println("Same");
//    }else {
//        System.out.println("Different");
//    }
//
//    String ex1 = " prog ramming";
//    String ex2 = "program ming   ";
//    String ex3 = "    progr amming     ";
//
//       System.out.println("ex1 : " + ex1.length() + ", ex2 : " + ex2.length() + ", ex3 : " + ex3.length());
//
//    ex1 = ex1.trim();
//    ex2 = ex2.trim();
//    ex3 = ex3.trim();
//        System.out.println("ex1 : " + ex1.length() + ", ex2 : " + ex2.length() + ", ex3 : " + ex3.length());
//        System.out.println(ex1);
//        System.out.println(ex2);
//        System.out.println(ex3);
//
//    String search_word = "JaVa";
//    subject = subject.toLowerCase();
//    search_word = search_word.toLowerCase();
//
//        if(subject.indexOf(search_word) != -1){
//        System.out.println("exists");
//    }else {
//        System.out.println("no word");
//    }
//    search_word = search_word.toUpperCase();
//        System.out.println(search_word);
//
//    String color = "red, blue, white, orange";
//    String[] arr = color.split(", ");
//        for(int i = 0; i < arr.length; i++){
//        System.out.println(arr[i]);
//    }
//
//    String[] arr2 = subject.split(" ");
//        for (int i = 0; i < arr2.length; i++){
//        System.out.println(arr2[i]);
//    }
//
//    String[] arr3 = subject.split("ing");
//        for (int i = 0; i < arr3.length; i++){
//        System.out.println(arr3[i]);
//    }
//
//    String rep_str = subject.replace("java","python");
//        System.out.println(subject);
//        System.out.println(rep_str);
//
//        System.out.println(subject.contains("class"));
//        if (subject.contains("class")){
//        System.out.println("subject");
//    }else {
//        System.out.println("not subject");
//    }
//
//    String url = "https://www.naver.com";
//        System.out.println(url.startsWith("http"));
//        if (url.startsWith("http")){
//        System.out.println("Web");
//    }else {
//        System.out.println("Not Web");
//    }
//        System.out.println(url.endsWith("kr"));
//        if (url.endsWith("kr")){
//        System.out.println("Korea");
//    }else {
//        System.out.println("Not Korea");
    //    int i = Integer.valueOf("123").intValue();
//    float f = Float.valueOf("23.5").floatValue();
//
//        System.out.println(i);
//                System.out.println(f);
//
//                int k = 15;
//                double d = 15.6;
//
//                String sk = String.valueOf(k);
//                String sd = String.valueOf(d);
//
//                System.out.println(sk);
//                System.out.println(sd);

//    ChildAirplane ca1 = new ChildAirplane();
//        ca1.flyMode = 1;
//                ca1.takeOff();
//                ca1.fly();
//                ca1.land();
//
//                ca1.flyMode = 2;
//                ca1.takeOff();
//                ca1.fly();
//                ca1.land();


//
//    Account account = new Account();
//        account.setBalance(10000);
//                System.out.println("Current balance : " + account.getBalance());
//
//                account.setBalance(10000000);
//                System.out.println("Current balance : " + account.getBalance());
//
//                account.setBalance(-3000);
//                System.out.println("Current balance : " + account.getBalance());




//    GrandParent gp = new GrandParent();
//        gp.name = "grand";
//                gp.age = 80;
//                gp.printGrandParentInfo();
//                System.out.println("-----------------");
//
//                Parent p = new Parent();
//                p.name = "parent";
//                p.age = 40;
//                p.job = "Edu";
//                // gp.printGrandParentInfo();
//                p.printParenInfo();
//                System.out.println("-----------------");
//
//                Child c = new Child();
//                c.name = "Child";
//                c.age = 10;
//                c.job = "student";
//                c.hobby = "dance";
//                c.printChildInfo();
//                System.out.println("-----------------");



//    Person p = new Person();
//        p.setNum(1);
//                p.setName("Hajni");
//                p.setDept("dept");
//                p.setAddress("address");
//                p.print();
//
//                Professor f = new Professor();
//                f.setNum(2);
//                f.setName("Mike");
//                f.setDept("Computer");
//                f.setAddress("Seoul");
//                String[] sub = {"Computer","C","Java"};
//                f.setSubjects(sub);
//
//                f.print();
//                f.print_subject();
//
//                Student s = new Student();
//                s.setNum(3);
//                s.setName("Paul");
//                s.setDept("Computer");
//                s.setAddress("Bucheon");
//                String[] studentClass = {"Java", "Compiler"};
//                s.setSubjects(studentClass);
//
//                s.print();
//                s.print_subjecs();
//
//                Staff t = new Staff();
//                t.setNum(4);
//                t.setName("Hajin");
//                t.setDept("Computer");
//                t.setAddress("Seoul");
//                t.setJob("Edu manager");
//
//                t.print();
//                t.print_job();

//    Parent p1 = new Parent();
//        p1.name = "hajni";
//                p1.age = 15;
//                p1.setMoney(10000);
//
//                p1.printParentIfo();
//
//                int money = p1.getMoney();
//                System.out.println(money);
//
//                Child c1 = new Child();
//                c1.name = "kikab";
//                c1.age = 18;
//                c1.setHobby("movie");
//
//                c1.printInfo();
//    Calculator cal1 = new Calculator();
//        cal1.powerOn();
//                System.out.println(cal1.plus(3,4,5));
//                System.out.println(cal1.divide(6,4));

//    Member m1 = new Member("Mike", "010-4658", "Seoul");
//    Member m2 = new Member("Harry", "010-4658", "Bucheons");
//    Member m3 = new Member();
//
//        m1.print();
//                m2.print();
//                m3.print();
//
//    Test test1 = new Test();
//    int ret1 = test1.add_int(10,20);
//    float ret2 = test1.add_float(3.5f,10.111f);
//    String ret3 = test1.add_string("Wellcome", "bye");
//
//        System.out.println(ret1);
//                System.out.println(ret2);
//                System.out.println(ret3);
//
//                Test2 test2 = new Test2();
//
//                int ret4 = test2.add(10,20);
//                float ret5 = test2.add(3.5f,10.111f);
//                String  ret6 = test2.add("Wellcome","bye");
//
//                System.out.println(ret4);
//                System.out.println(ret5);
//                System.out.println(ret6);
//
//                System.out.println(test2.add(3.14f,100));
//                System.out.println(test2.add(3,4,5));
// &&(and 전부 true일때 true) ||(or 둘중 하나라도 true일때 true)
//        int a = 10;
//        int b = 20;
//
//        System.out.println(a == 10 && b == 20);
//        System.out.println(a > 10 && b == 20);
//        System.out.println(a == 10 && b == 10);
//        System.out.println(a == 10 || b == 20);
//        System.out.println(a < 10 || b > 20);

//         char c1 = 'A';
//         String name = "Mike";
//
//        System.out.println(c1);
//        System.out.println(name);

//        Scanner sc = new Scanner(System.in);
//        String name;
//        int Math;
//
//        System.out.println("name : ");
//        name = sc.next();
//
//        System.out.println("math score : ");
//        Math = sc.nextInt();
//
//        System.out.println(name + " : " + Math);
}
