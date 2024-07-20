package com.rash.contactapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import com.rash.contactapp.model.Contact
import com.rash.contactapp.ui.theme.ContactAppTheme
import javax.sql.DataSource

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ContactAppTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = { Text("Contacts App") },
                            actions = {
                                val context = LocalContext.current
                                IconButton(onClick = {
                                    val i = Intent(Intent.ACTION_DIAL, "tel: 2025548984".toUri())
                                    context.startActivity(i)
                                }) {
                                    Icon(
                                        painter = painterResource(id = R.drawable.home),
                                        contentDescription = "home"
                                    )
                                }
                            },
                        )
                    }
                )
                { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {
                        ContactList(contacts = com.rash.contactapp.data.DataSource().getContactData())
                    }
                }
            }
        }
    }
}


@Composable
fun Contact(contact: Contact, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,

        modifier = modifier
            .background(
                Color.LightGray
            )
            .clickable(enabled = true) {
                val i = Intent(Intent.ACTION_DIAL, "tel:${contact.phone}".toUri())
                context.startActivity(i)
            }

    ) {
        Image(
            painter = painterResource(id = contact.picture), contentDescription = stringResource(
                id = contact.name
            )
        )
        Text(
            text = stringResource(id = contact.name),
            textAlign = TextAlign.Center,
        )
        SelectionContainer {
            Text(
                text = contact.phone,
                textAlign = TextAlign.Center,
            )

        }
    }


}

@Composable
fun ContactList(contacts: List<Contact>) {
    LazyVerticalGrid(columns = GridCells.Adaptive(minSize = 128.dp)) {
        items(contacts) {
            Contact(contact = it)
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun ContactItemPreview() {
    ContactList(contacts = com.rash.contactapp.data.DataSource().getContactData())
}