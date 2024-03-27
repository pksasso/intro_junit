package carrinho;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import produto.Produto;
import produto.ProdutoNaoEncontradoException;

@DisplayName("Classe para teste do carrinho")
public class CarrinhoTest {

    private Carrinho carrinho;

    @DisplayName("Inicializando classe para teste do carrinho")
    @BeforeEach
    public void inicializa() {
        carrinho = new Carrinho();

        Produto item1 = new Produto("a", 1.00);
        Produto item2 = new Produto("b", 2.00);
        Produto item3 = new Produto("c", 3.00);

        carrinho.addItem(item1);
        carrinho.addItem(item2);
        carrinho.addItem(item3);
    }


    @DisplayName("Adicao no carrinho")
    @Test
    public void testAdicionaNoCarrinho() {
        Assertions.assertEquals(carrinho.getQtdeItems(), 3);

        carrinho.addItem(new Produto("teste", 1 ));

        Assertions.assertEquals(carrinho.getQtdeItems(), 4);
        Assertions.assertEquals(carrinho.getValorTotal(), 7);
    }

    @DisplayName("Remove do carrinho")
    @Test
    public void testRemoveDoCarrinho() {
        Produto product =  new Produto("a", 1.00);

        try {
            Assertions.assertEquals(carrinho.getQtdeItems(), 3);
            carrinho.removeItem(product);
            Assertions.assertEquals(carrinho.getQtdeItems(), 2);
        } catch (ProdutoNaoEncontradoException e) {
            Assertions.assertTrue(true);
        }
    }

    @DisplayName("Esvaziar carrinho")
    @Test
    public void testEsvaziaCarrinho() {
        Assertions.assertEquals(carrinho.getQtdeItems(), 3);
        Assertions.assertEquals(carrinho.getValorTotal(), 6);
        carrinho.esvazia();
        Assertions.assertEquals(carrinho.getQtdeItems(), 0);
        Assertions.assertEquals(carrinho.getValorTotal(), 0);
    }

    @DisplayName("Valor total")
    @Test
    public void testValorTotal() {
        Assertions.assertEquals(carrinho.getValorTotal(), 6);
        Produto product =  new Produto("a", 1.00);
        carrinho.addItem(product);
        Assertions.assertEquals(carrinho.getValorTotal(), 7);
    }
}
