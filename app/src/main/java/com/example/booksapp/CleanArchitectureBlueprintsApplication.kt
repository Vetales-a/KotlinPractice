package com.example.booksapp

import android.app.Application
import android.os.Bundle

class CleanArchitectureBlueprintsApplication : Application() {

    private val booksRepository: BooksRepositoryImpl
        get() = ServiceLocator.provideBooksRepository(this)

    val getBookUseCase: GetBookUseCase
        get() = GetBookUseCase(booksRepository)

    val getBookmarksUseCase: GetBookmarksUseCase
        get() = GetBookmarkUseCase(booksRepository)

    val bookmarkUseCase: BookmarkUseCase
        get() = BookmarkBookUseCase(booksRepository)

    val unbookmarkBookUseCase: UnbookmarkBookUseCase
        get() = UnbookmarkBookUseCase(booksRepository)

    val bookWithStatusMapper = BookWithStatusMapper()

    override fun onCreate(savedInstanceState: Bundle) {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}