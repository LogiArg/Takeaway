package is.vidmot;

import is.vinnsla.Customer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/******************************************************************************
 *  Nafn    : Logi Arnarsson
 *  T-póstur: loa13@hi.is
 *
 *      Alla hönnun á forritinu gerði ég sjálfur. Ef það er sambærileg hönnun
 *      frá öðrum nemanda hefur það verið út frá minni hönnun.
 *
 *  Lýsing  : Notast ef það er kominn viðskiptavinur í kerfið. Sýnir notenda
 *  og tekur við lykilorði.
 *
 *****************************************************************************/

public class PasswordController {
    //Viðmótsbreytur
    @FXML
    public Label fxClient;
    @FXML
    public Button fxCancel1;
    @FXML
    public Button fxCancel;

    //Tengsl við vinnslu
    private Customer customer;

    /**
     * Sækir viðskiptavininn til þess að geta notað nafn hans.
     * Ef það er enginn viðskiptavinur í kerfinu og þetta opnast,
     * sem ætti ekki að gerast, þá prentast 'Unknown Client'. Annars
     * þá er nafn viðskiptavins sett sem texti Labels-ins.
     */
    public void initialize() {
        OrderController orderController = (OrderController) ViewSwitcher.lookup(View.ORDER);
        customer = orderController.getCustomer();
        if (customer != null) {
            fxClient.textProperty().bind(customer.nameProperty());
        } else {
            fxClient.setText("Unknown Client");
        }
    }

    /**
     * Ef ýtt er á 'Til Baka' takkann fer maður aftur í pontun-view
     *
     * @param event - atburðurinn sem viðmótshluturinn fékk.
     */
    public void fxCancel(ActionEvent event) {
        ViewSwitcher.switchTo(View.ORDER);
    }

    /**
     * Ef ýtt er á 'Áfram' takkann fer maður aftur í pontun-view
     * og ekkert meira gerist vegna verkefnalýsingu.
     *
     * @param event - atburðurinn sem viðmótshluturinn fékk.
     */
    public void fxCancel1(ActionEvent event) {
        ViewSwitcher.switchTo(View.ORDER);
    }
}
