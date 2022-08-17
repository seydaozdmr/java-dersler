package j_oop.nested;

public class Lemur {
    /**
     * Once the object has been assigned to a new reference type, only the methods and variables
     * available to that reference type are callable on the object without an explicit cast. For
     * example, the following snippets of code will not compile:
     */
    /**
     * In Java, all objects are accessed by reference, so as a developer you never have direct
     * access to the object itself. Conceptually, though, you should consider the object as the entity
     * that exists in memory, allocated by the Java Runtime Environment. Regardless of the type
     * of the reference you have for the object in memory, the object itself doesn’t change. For
     * example, since all objects inherit java.lang.Object, they can all be reassigned to
     * java.lang.Object, as shown in the following example:
     * Lemur lemur = new Lemur();
     * Object lemurAsObject = lemur;
     * Even though the Lemur object has been assigned to a reference with a different type, the
     * object itself has not changed and still exists as a Lemur object in memory. What has changed,
     * then, is our ability to access methods within the Lemur class with the lemurAsObject reference.
     * Without an explicit cast back to Lemur, as you see in the next section, we no longer
     * have access to the Lemur properties of the object.
     * We can summarize this principle with the following two rules:
     * 1. The type of the object determines which properties exist within the object in memory.
     * 2. The type of the reference to the object determines which methods and variables are
     * accessible to the Java program.
     *
     * It therefore follows that successfully changing a reference of an object to a new reference
     * type may give you access to new properties of the object; but remember, those properties
     * existed before the reference change occurred.
     */
}
