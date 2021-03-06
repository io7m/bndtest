/*
 * Copyright © 2019 Mark Raynsford <code@io7m.com> http://io7m.com
 *
 * Permission to use, copy, modify, and/or distribute this software for any
 * purpose with or without fee is hereby granted, provided that the above
 * copyright notice and this permission notice appear in all copies.
 *
 * THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
 * WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY
 * SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
 * WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
 * ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF OR
 * IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 */


package com.io7m.bndtest.main;

import com.io7m.bndtest.api.SpeakType;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

@Component(immediate = true)
public final class SpeakMain
{
  private final AtomicReference<SpeakType> speaker;

  public SpeakMain()
  {
    this.speaker = new AtomicReference<>();
  }

  @Reference
  public void onSpeakAvailable(final SpeakType new_speaker)
  {
    this.speaker.set(Objects.requireNonNull(new_speaker, "speaker"));
  }

  @Activate
  public void onActivate()
  {
    this.speaker.get().speak("Hello again, again!");
  }
}
