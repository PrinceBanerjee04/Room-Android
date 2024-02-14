import android.app.AlertDialog
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.roomdatabase.ContactEvent
import com.example.roomdatabase.ContactState

@Composable
fun AddContactDialog(
    state: ContactState,
    onEvent: (ContactEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    AlertDialog(
        modifier = modifier,
        onDismissRequest = { onEvent(ContactEvent.HideDialog) },
        title = { Text(text = "Add Contact")},
        text = {
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                TextField(value = state.firstName, onValueChange = {
                    onEvent(ContactEvent.SetFirstName(it))
                },
                    placeholder = {
                        Text(text = "First Name")
                    }
                )

                TextField(value = state.firstName, onValueChange = {
                    onEvent(ContactEvent.SetLastName(it))
                },
                    placeholder = {
                        Text(text = "Last Name")
                    }
                )

                TextField(value = state.firstName, onValueChange = {
                    onEvent(ContactEvent.SetPhoneNumber(it))
                },
                    placeholder = {
                        Text(text = "Phone Number")
                    }
                )
            }
        },
        buttons={
            Box(modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.CenterEnd
                ){
                Button(onClick = {
                    onEvent(ContactEvent().SaveContact)
                }) {
                    Text(text = "Save Contact")
                }
            }
        }
    )
}