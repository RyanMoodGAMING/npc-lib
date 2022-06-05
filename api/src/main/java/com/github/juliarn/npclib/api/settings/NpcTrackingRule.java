/*
 * This file is part of npc-lib, licensed under the MIT License (MIT).
 *
 * Copyright (c) 2022 Julian M., Pasqual K. and contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.github.juliarn.npclib.api.settings;

import com.github.juliarn.npclib.api.Npc;
import org.jetbrains.annotations.NotNull;

@FunctionalInterface
public interface NpcTrackingRule<P> {

  static @NotNull <P> NpcTrackingRule<P> allPlayers() {
    return (npc, player) -> true;
  }

  // TODO: come up with a better name for this
  static @NotNull <P> NpcTrackingRule<P> onlyUnspecifiedPlayers() {
    return (npc, player) -> !npc.includedPlayers().contains(player);
  }

  static @NotNull <P> NpcTrackingRule<P> onlyExplicitlyIncludedPlayers() {
    return (npc, player) -> npc.includedPlayers().contains(player);
  }

  boolean shouldTrack(@NotNull Npc<?, P, ?> npc, @NotNull P player);
}