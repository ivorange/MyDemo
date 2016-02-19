// BookInfo.aidl
package co.example.ivorange.studyproject;

// Declare any non-default types here with import statements

interface BookInfo {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void setName(String name);
       void setPrice(int price);
       void ssetPublish(String pname);
       //显示图书的信息
       String display();
}
