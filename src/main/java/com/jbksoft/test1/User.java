package com.jbksoft.test1;

public class User {
    private String name;
    private int id;

    public User(String name, int id) {
       this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

//    public boolean equals(Object obj) {
//        if(obj instanceof User && ((User)obj).id == this.id)
//            return true;
//        else
//            return false;
//
//    }

    // Overriding equals() to compare two Complex objects
    @Override
    public boolean equals(Object o) {

        // If the object is compared with itself then return true
        if (o == this) {
            return true;
        }

        /* Check if o is an instance of Complex or not
          "null instanceof [type]" also returns false */
        if (!(o instanceof User)) {
            return false;
        }

        // typecast o to Complex so that we can compare data members
        User c = (User) o;

        // Compare the data members and return accordingly
//        return Double.compare(re, c.re) == 0
//                && Double.compare(im, c.im) == 0;
        return true;
    }

   /* @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        return name != null ? name.equals(user.name) : user.name == null;
    }*/

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + id;
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
