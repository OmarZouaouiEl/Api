package com.example.api

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScopeInstance.weight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.leanback.widget.SearchBar
import coil.compose.rememberImagePainter

@Composable
fun CharactersScreen(viewModel: CharactersViewModel, onCharacterClick: (Character) -> Unit) {
    Column {
        SearchBar(modifier = Modifier.fillMaxWidth()) { query ->
        }

        LazyColumn {
            items(viewModel.characters.value ?: emptyList()) { character ->
                CharacterItem(character = character, onCharacterClick = onCharacterClick)
            }
        }
    }
}

@Composable
fun CharacterItem(character: Int, onCharacterClick: (Character) -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onCharacterClick(character) }
            .padding(16.dp),
        contentAlignment = Alignment.CenterStart
    ) {
        Text(
            text = character.name,
            modifier = Modifier.weight(1f),
            overflow = TextOverflow.Ellipsis,
            maxLines = 1
        )
        Image(
            painter = rememberImagePainter(character.image),
            contentDescription = null,
            modifier = Modifier.size(50.dp)
        )
    }
}