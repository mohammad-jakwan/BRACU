class Patient {
    public Integer id;
    public String name;
    public Integer age;
    public String bloodGroup;
    public Patient next;
    public Patient prev;

    public Patient(Integer id, String name, Integer age, String bloodGroup, Patient next, Patient prev) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.bloodGroup = bloodGroup;
        this.next = next;
        this.prev = prev;
    }

    @Override
    public String toString() {
        return "Patient{id=" + id + ", name=" + name + ", age=" + age + ", bloodGroup=" + bloodGroup + "}";
    }
}
