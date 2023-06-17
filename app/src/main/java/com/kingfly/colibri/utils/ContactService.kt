package com.kingfly.colibri.utils

import android.Manifest
import android.R
import android.annotation.SuppressLint
import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.provider.ContactsContract
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.kingfly.colibri.data.Contact

class ContactService {
    companion object {
        @SuppressLint("Range")
        fun GetContactListe(context: Context): MutableList<Contact> {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (ContextCompat.checkSelfPermission(
                        context,
                        Manifest.permission.READ_CONTACTS
                    ) != PackageManager.PERMISSION_GRANTED
                ) {
                    val phones = context.contentResolver.query(
                        ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                        null,
                        null,
                        null,
                        ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME + " ASC"
                    )
                    val contacts: MutableList<Contact> = mutableListOf()

                    if (phones!!.count > 0) while (phones!!.moveToNext()) {
                        val name =
                            phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME))
                        val phoneNumber =
                            phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER))

                        val contact = Contact(name, phoneNumber)
                        contacts.add(contact)
                    }
                    phones.close()

                    return contacts
                }
            }

            return mutableListOf<Contact>()

        }

        fun requestContactPermission(activity: Activity) {
            val PERMISSIONS_REQUEST_READ_CONTACTS = 1
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (ContextCompat.checkSelfPermission(
                        activity,
                        Manifest.permission.READ_CONTACTS
                    ) != PackageManager.PERMISSION_GRANTED
                ) {
                    if (ActivityCompat.shouldShowRequestPermissionRationale(
                            activity,
                            Manifest.permission.READ_CONTACTS
                        )
                    ) {
                        val builder = AlertDialog.Builder(activity)
                        builder.setTitle("Permission de lecture de contact")
                        builder.setPositiveButton(R.string.ok, null)
                        builder.setMessage("Nous avons besoin d'avoir accès à la liste de contact pour faciliter votre recherche")
                        builder.setOnDismissListener {
                            activity.requestPermissions(
                                arrayOf<String>(
                                    Manifest.permission.READ_CONTACTS
                                ), PERMISSIONS_REQUEST_READ_CONTACTS
                            )
                        }
                        builder.show()
                    } else {
                        ActivityCompat.requestPermissions(
                            activity, arrayOf<String>(Manifest.permission.READ_CONTACTS),
                            PERMISSIONS_REQUEST_READ_CONTACTS
                        )
                    }
                }
            }
        }
    }
}