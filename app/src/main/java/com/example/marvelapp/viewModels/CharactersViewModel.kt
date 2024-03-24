package com.example.marvelapp.viewModels

import android.annotation.SuppressLint
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.marvelapp.data.DataSourcePage
import com.example.marvelapp.model.MarvelResults
import com.example.marvelapp.repository.CharactersRepository
import com.example.marvelapp.state.ComicsState
import com.example.marvelapp.state.MarvelResultsState
import com.example.marvelapp.state.StoriesState
import com.example.marvelapp.state.ThumbnailState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject
import dagger.hilt.android.lifecycle.HiltViewModel

@HiltViewModel
class CharactersViewModel @Inject constructor(private val repo: CharactersRepository): ViewModel() {
    private val _characters = MutableStateFlow<List<MarvelResults>>(emptyList())
    val characters = _characters.asStateFlow()


var characterDetails by mutableStateOf(MarvelResultsState())
    private set

    val charactersPage = Pager(PagingConfig(10)){
        DataSourcePage(repo)
    }.flow.cachedIn(viewModelScope)

     fun fetchCharacter(name: String){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                val result = repo.getCharacters(name)
                _characters.value = result ?: emptyList()
            }
        }
    }

     @SuppressLint("SuspiciousIndentation")
     fun getCharacterById(id: Int){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                val getResponseCharacter = repo.getCharacterById(id)
                  if (getResponseCharacter != null) {
                      for (detail in getResponseCharacter.results) {
                          characterDetails = characterDetails.copy(
                              id  = detail.id,
                           name = detail.name,
                           description = detail.description,
                           modified = detail.modified,
                           thumbnail = ThumbnailState(
                               detail.thumbnail.path,
                               detail.thumbnail.extension
                           ),
                           resourceURI = detail.resourceURI,
                           comics = ComicsState(
                               detail.comics.available,
                               detail.comics.collectionURI,
                               detail.comics.items.toList(),
                               detail.comics.returned),
                           series = ComicsState(
                               detail.series.available,
                               detail.series.collectionURI,
                               detail.series.items.toList(),
                               detail.series.returned),
                           stories = StoriesState(
                               detail.stories.available,
                               detail.stories.collectionURI,
                               detail.stories.items.toList(),
                               detail.stories.returned),
                           events = ComicsState(
                               detail.events.available,
                               detail.events.collectionURI,
                               detail.events.items.toList(),
                               detail.events.returned),
                            urls = detail.urls.toList()
                          )
                      }

                  }
            }
        }
    }

     fun cleanDetail(){
         characterDetails = characterDetails.copy(
             id  = 0,
             name = "",
             description = "",
             modified = "",
             thumbnail = ThumbnailState("", ""),
             resourceURI = "",
             comics = ComicsState(0, "", listOf(), 0),
             series = ComicsState(0, "", listOf(), 0),
             stories = StoriesState(0,"", listOf(), 0),
             events = ComicsState(0, "", listOf(), 0),
             urls = listOf()
        )
    }
}