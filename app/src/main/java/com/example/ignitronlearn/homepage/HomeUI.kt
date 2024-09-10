package com.example.ignitronlearn.homepage

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.ui.platform.LocalContext
import android.content.Intent
import android.net.Uri
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.*

@Composable
fun HomeUI(navController: NavController) {
            val context = LocalContext.current
            val phoneNumber = "01126701728" // Replace with the desired phone number
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))

            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {

                Box(
                    modifier = Modifier.fillMaxWidth().padding(16.dp)
                ) {
                    Button(
                        onClick = { context.startActivity(intent) },
                        modifier = Modifier.align(Alignment.CenterStart).fillMaxWidth(),
                        elevation = ButtonDefaults.buttonElevation(24.dp)
                    ) {

                        Icon(
                            imageVector = Icons.Filled.Phone, // Replace with your desired icon
                            contentDescription = "Call",
                            modifier = Modifier.size(ButtonDefaults.IconSize)
                        )
                        Spacer(Modifier.size(ButtonDefaults.IconSpacing))

                        Text("Call Helpline(NDRF)")
                    }
                }

                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    item {
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            elevation = CardDefaults.cardElevation(4.dp)
                        ) {
                            Column(
                                modifier = Modifier
                                    .padding(16.dp)
                                    .fillMaxWidth(),
                            ) {
                                Text(
                                    text = "\"When disaster arrives the time to prepare has passed\"",
                                    style = TextStyle(
                                        fontSize = 18.sp,
                                        fontStyle = FontStyle.Italic,
                                        textAlign = TextAlign.Center
                                    ),
                                    modifier = Modifier.padding(bottom = 8.dp)
                                )
                                Row(modifier = Modifier.fillMaxWidth()) {
                                    Spacer(modifier = Modifier.weight(1f))
                                    Text(
                                        text = "- Steven Cyros",
                                        style = TextStyle(
                                            fontSize = 16.sp, fontWeight = FontWeight.Light,
                                            textAlign = TextAlign.End
                                        )
                                    )
                                }
                            }
                        }
                    }
                    items(disasters.chunked(2)) { rowItems ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp),
                            horizontalArrangement = Arrangement.SpaceAround
                        ) {
                            rowItems.forEach { disasters ->
                                Card(
                                    elevation = CardDefaults.cardElevation(4.dp),
                                    modifier = Modifier
                                        .weight(1f)
                                        .padding(4.dp)
                                        .clickable {
                                            navController.navigate("DisasterDetails/${disasters.nameResourceId}/${disasters.todoResourceId}/${disasters.todoImageResourceId}/${disasters.helplineResourceId}/${disasters.newsResourceId}")
                                        }
                                ) {
                                    Column {
                                        Image(
                                            painter = painterResource(id = disasters.imageResourceId), // Replace with your image
                                            contentDescription = null,
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .height(150.dp), // Adjust height as needed
                                            contentScale = ContentScale.Crop
                                        )
                                        Text(
                                            text = stringResource(id = disasters.nameResourceId),
                                            modifier = Modifier.padding(8.dp)
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
}

