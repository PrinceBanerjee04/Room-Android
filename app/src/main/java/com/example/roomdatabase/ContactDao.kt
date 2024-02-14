package com.example.roomdatabase

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

//DAO Interface for Contacts
@Dao
interface ContactDao {

    @Upsert // Mixture of Updating and Inserting
    suspend fun upsertContact(contact: Contact)

    @Delete
    suspend fun deleteContact(contact: Contact)

    @Query("SELECT * FROM contact ORDER BY firstName ASC")
    fun getContactsOrderedByFirstName(): Flow<List<Contact>>

    @Query("SELECT * FROM contact ORDER BY lastName ASC")
    fun getContactsOrderedByLastName(): Flow<List<Contact>>

    @Query("SELECT * FROM contact ORDER BY phoneNumber ASC")
    fun getContactsOrderedByPhoneNumber(): Flow<List<Contact>>
}