package com.example.ignitronlearn.homepage

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun DisasterDetails(name:Int?,todo: Int?,todoImage: Int?, helpline: Int?,newsLink: Int?) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(16.dp))

                val context = LocalContext.current
                val phoneNumber = "01126701728" // Replace with the desired phone number

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    //var intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                    Button(onClick = { context.startActivity(Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))) },modifier = Modifier
                        .align(Alignment.CenterStart)
                        .fillMaxWidth()) {

                        Icon(
                            imageVector = Icons.Filled.Phone, // Replace with your desired icon
                            contentDescription = "Call",
                            modifier = Modifier.size(ButtonDefaults.IconSize)
                        )
                        Spacer(Modifier.size(ButtonDefaults.IconSpacing))

                        Text("Call Helpline(NDRF)")
                    }
                }

                if (todo != null) {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp)
                        ) {
                            Text(
                                text = "Things todo",
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Center
                            )

                            Spacer(modifier = Modifier.height(8.dp))

                            Text(
                                text = stringResource(id = todo),
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Normal,
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Start
                            )

                            todoImage?.let { painterResource(id = it) }?.let {
                                Image(
                                    painter = it,
                                    contentDescription = null,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(16.dp)
                                )
                            }
                        }
                    }
                }

                if (helpline != null) {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp)
                        ) {
                            Text(
                                text = "Helpline",
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Center
                            )
                            Spacer(modifier = Modifier.height(8.dp))

                            SelectionContainer {
                                Text(
                                    text = stringResource(id = helpline),
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Normal,
                                    modifier = Modifier.fillMaxWidth(),
                                    textAlign = TextAlign.Start,

                                    )
                            }
                            //val videoUri = "android.resource://{com.example.crisisaid}/raw/The Earthquake Plan _ Family _ Little Fox _ Bedtime Stories"
                        }
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    elevation = CardDefaults.elevatedCardElevation(40.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) {

                        val newsUrl =
                            newsLink?.let { stringResource(id = it) }// Replace with actual URL


                        Text(
                            text = "Click to see latest News from BBC for",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Normal,
                            color = Color.Blue,
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable {
                                    //intent = Intent(Intent.ACTION_VIEW, Uri.parse(newsUrl))
                                    context.startActivity(
                                        Intent(
                                            Intent.ACTION_VIEW,
                                            Uri.parse(newsUrl)
                                        )
                                    )
                                },
                            textAlign = TextAlign.Center
                        )
                        Text(
                            text = name?.let { stringResource(id = it) }?:"no name",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Normal,
                            color = Color.Blue,
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable {
                                    //intent = Intent(Intent.ACTION_VIEW, Uri.parse(newsUrl))
                                    context.startActivity(
                                        Intent(
                                            Intent.ACTION_VIEW,
                                            Uri.parse(newsUrl)
                                        )
                                    )
                                },
                            textAlign = TextAlign.Center
                        )

//                        Spacer(modifier = Modifier.height(8.dp))
//
//
//
//                        Text(
//                            text = "Read more on BBC",
//                            color = Color.Blue,modifier = Modifier.clickable {
//                                intent = Intent(Intent.ACTION_VIEW, Uri.parse(newsUrl))
//                                context.startActivity(intent)
//                            }
//                        )
                    }
                }
            }
        }