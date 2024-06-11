package others

@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
annotation class MyAnnotation(val value : Int)

@MyAnnotation(1)
class MyClassContainsAnnotation {
    fun print() {
        
    }
}