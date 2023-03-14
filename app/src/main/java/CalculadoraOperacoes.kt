import androidx.compose.material.Text

class CalculadoraOperacoes {

    fun somar(n1:Double, n2:Double): Double = n1 + n2

    fun subtrair(n1: Double, n2: Double): Double = n1 - n2

    fun multiplica(n1: Double, n2: Double): Double = n1 * n2

    fun dividir(n1: Double, n2: Double): Double{
        if (n2 == 0.0) throw IllegalAccessError("Não é possivel dividir numero por zero")
        return n1 / n2
    }
}